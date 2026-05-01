const { createServer } = require('http');
const { URL } = require('url');
const next = require('next');

const port = parseInt(process.env.PORT || '3000', 10);
const hostname = '0.0.0.0';

const app = next({ dev: false, hostname, port });
const handle = app.getRequestHandler();

app.prepare().then(() => {
  const server = createServer((req, res) => {
    try {
      const parsedUrl = new URL(req.url, `http://${hostname}:${port}`);
      handle(req, res, parsedUrl);
    } catch (err) {
      console.error('Error handling request:', err);
      res.statusCode = 500;
      res.end('Internal Server Error');
    }
  });

  server.listen(port, hostname, () => {
    console.log(`> Ready on http://${hostname}:${port}`);
  });

  // Keep process alive
  process.on('SIGTERM', () => {
    server.close(() => process.exit(0));
  });

  // Prevent unhandled rejections from crashing
  process.on('unhandledRejection', (err) => {
    console.error('Unhandled rejection:', err);
  });
});
