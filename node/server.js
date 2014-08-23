var express = require('express');
var app = express();

app.use('/', express.static('/home/robin/workspace/active_projects/help-everyone/ui/src'));

app.listen(8000);