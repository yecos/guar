package com.hpplay.component.protocol.plist;

import com.google.common.primitives.UnsignedBytes;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class PropertyListParser {
    private static final int READ_BUFFER_LENGTH = 2048;
    private static final int TYPE_ASCII = 2;
    private static final int TYPE_BINARY = 1;
    private static final int TYPE_ERROR_BLANK = 10;
    private static final int TYPE_ERROR_UNKNOWN = 11;
    private static final int TYPE_XML = 0;

    public static void convertToASCII(File file, File file2) {
        NSObject parse = parse(file);
        if (parse instanceof NSDictionary) {
            saveAsASCII((NSDictionary) parse, file2);
        } else {
            if (!(parse instanceof NSArray)) {
                throw new PropertyListFormatException("The root of the given input property list is neither a Dictionary nor an Array!");
            }
            saveAsASCII((NSArray) parse, file2);
        }
    }

    public static void convertToBinary(File file, File file2) {
        saveAsBinary(parse(file), file2);
    }

    public static void convertToGnuStepASCII(File file, File file2) {
        NSObject parse = parse(file);
        if (parse instanceof NSDictionary) {
            saveAsGnuStepASCII((NSDictionary) parse, file2);
        } else {
            if (!(parse instanceof NSArray)) {
                throw new PropertyListFormatException("The root of the given input property list is neither a Dictionary nor an Array!");
            }
            saveAsGnuStepASCII((NSArray) parse, file2);
        }
    }

    public static void convertToXml(File file, File file2) {
        saveAsXML(parse(file), file2);
    }

    private static int determineType(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return 10;
        }
        if (trim.startsWith("bplist")) {
            return 1;
        }
        if (trim.startsWith("(") || trim.startsWith("{") || trim.startsWith(Operator.Operation.DIVISION)) {
            return 2;
        }
        return trim.startsWith(Operator.Operation.LESS_THAN) ? 0 : 11;
    }

    public static NSObject parse(String str) {
        return parse(new File(str));
    }

    public static byte[] readAll(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void saveAsASCII(NSDictionary nSDictionary, File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("The output directory does not exist and could not be created.");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
        try {
            outputStreamWriter.write(nSDictionary.toASCIIPropertyList());
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void saveAsBinary(NSObject nSObject, File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("The output directory does not exist and could not be created.");
        }
        BinaryPropertyListWriter.write(file, nSObject);
    }

    public static void saveAsGnuStepASCII(NSDictionary nSDictionary, File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("The output directory does not exist and could not be created.");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
        try {
            outputStreamWriter.write(nSDictionary.toGnuStepASCIIPropertyList());
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void saveAsXML(NSObject nSObject, File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("The output directory does not exist and could not be created.");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            saveAsXML(nSObject, fileOutputStream);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static NSObject parse(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void saveAsBinary(NSObject nSObject, OutputStream outputStream) {
        BinaryPropertyListWriter.write(outputStream, nSObject);
    }

    private static int determineType(byte[] bArr) {
        byte b10;
        int i10 = 0;
        if (bArr.length >= 3 && (bArr[0] & UnsignedBytes.MAX_VALUE) == 239 && (bArr[1] & UnsignedBytes.MAX_VALUE) == 187 && (bArr[2] & UnsignedBytes.MAX_VALUE) == 191) {
            i10 = 3;
        }
        while (i10 < bArr.length && ((b10 = bArr[i10]) == 32 || b10 == 9 || b10 == 13 || b10 == 10 || b10 == 12)) {
            i10++;
        }
        return determineType(new String(bArr, i10, Math.min(8, bArr.length - i10)));
    }

    public static NSObject parse(byte[] bArr) {
        return parse(new ByteArrayInputStream(bArr));
    }

    public static NSObject parse(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        int determineType = determineType(inputStream, 0);
        if (determineType == 0) {
            return XMLPropertyListParser.parse(inputStream);
        }
        if (determineType == 1) {
            return BinaryPropertyListParser.parse(inputStream);
        }
        if (determineType == 2) {
            return ASCIIPropertyListParser.parse(inputStream);
        }
        if (determineType == 10) {
            return null;
        }
        throw new PropertyListFormatException("The given data is not a property list of a supported format.");
    }

    public static void saveAsASCII(NSArray nSArray, File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("The output directory does not exist and could not be created.");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
        try {
            outputStreamWriter.write(nSArray.toASCIIPropertyList());
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void saveAsGnuStepASCII(NSArray nSArray, File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("The output directory does not exist and could not be created.");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
        try {
            outputStreamWriter.write(nSArray.toGnuStepASCIIPropertyList());
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void saveAsXML(NSObject nSObject, OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        outputStreamWriter.write(nSObject.toXMLPropertyList());
        outputStreamWriter.flush();
    }

    private static int determineType(InputStream inputStream, int i10) {
        int read;
        int i11 = i10 + 1024;
        if (inputStream.markSupported()) {
            inputStream.mark(i11);
        }
        inputStream.skip(i10);
        boolean z10 = false;
        while (true) {
            i10++;
            if (i10 > i11) {
                inputStream.reset();
                return determineType(inputStream, i11);
            }
            read = inputStream.read();
            z10 = i10 < 3 && ((i10 == 0 && read == 239) || (z10 && ((i10 == 1 && read == 187) || (i10 == 2 && read == 191))));
            if (read == -1 || (read != 32 && read != 9 && read != 13 && read != 10 && read != 12 && !z10)) {
                break;
            }
        }
        if (read == -1) {
            return 10;
        }
        byte[] bArr = new byte[8];
        bArr[0] = (byte) read;
        int determineType = determineType(new String(bArr, 0, inputStream.read(bArr, 1, 7)));
        if (inputStream.markSupported()) {
            inputStream.reset();
        }
        return determineType;
    }
}
