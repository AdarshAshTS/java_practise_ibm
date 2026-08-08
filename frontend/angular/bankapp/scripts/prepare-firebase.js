const fs = require('fs');
const path = require('path');

const browserDir = path.join(__dirname, '..', 'dist', 'bank-app', 'browser');
const sourceFile = path.join(browserDir, 'index.csr.html');
const targetFile = path.join(browserDir, 'index.html');

if (!fs.existsSync(sourceFile)) {
  console.error(`Expected Angular output not found at ${sourceFile}`);
  process.exit(1);
}

fs.copyFileSync(sourceFile, targetFile);
console.log(`Created ${path.relative(process.cwd(), targetFile)} from ${path.relative(process.cwd(), sourceFile)}`);
