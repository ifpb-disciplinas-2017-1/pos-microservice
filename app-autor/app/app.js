var  express = require('express');
var  mongo = require('mongoose');
// var  fs = require('fs');
var  bodyParser = require('body-parser');

//Conexão com o MongoDB
var  mongoUri = 'mongodb://mongo:27017/autores';
mongo.connect(mongoUri);
var db = mongo.connection;
db.on('error', function () {
  throw new Error('não pode ser conectar a ' + mongoUri);
});

var  app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

require('./models/autor');
require('./routes')(app);

//Porta de escuta do servidor
app.listen(8080, function() {
	console.log('Servidor online');
});
