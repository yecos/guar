package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface DocumentationOrBuilder extends MessageLiteOrBuilder {
    String getDocumentationRootUrl();

    ByteString getDocumentationRootUrlBytes();

    String getOverview();

    ByteString getOverviewBytes();

    Page getPages(int i10);

    int getPagesCount();

    List<Page> getPagesList();

    DocumentationRule getRules(int i10);

    int getRulesCount();

    List<DocumentationRule> getRulesList();

    String getSummary();

    ByteString getSummaryBytes();
}
