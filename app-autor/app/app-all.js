// API REST de Autores em um unico arquivo
var  express = require('express');
var  mongo = require('mongoose');
var  bodyParser = require('body-parser');
var  app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

//Conexão com o MongoDB
var  mongoaddr = 'mongodb://mongo:27017/autores';
mongo.connect(mongoaddr);

//Esquema da collection do Mongo
var  autorSchema = mongo.Schema({
	nome : { type: String },
  email : { type: String },
  abreviacao : { type: String },
	ativo : Boolean,
	updated_at: { type: Date, default: Date.now },
});

//Model da aplicação
var  Model = mongo.model('Autor', autorSchema);

//GET - Retorna todos os registros existentes no banco
app.get("/api", function (req, res) {
  var autorProjection = {
      __v: false,
      _id: false,
      ativo: false,
      updated_at: false
  };
  Model.find({}, autorProjection, function(err, todos) {
	// Model.find(function(err, todos) {
      if (err) return next(err);
      res.json(todos);
	// }
})
});

//GET param - Retorna o registro correspondente da ID informada
app.get("/api/:nome?", function (req, res) {
	var nome = req.params.nome;
	Model.find({'nome': nome}, function(err, regs) {
		if (err) {
			// console.log(err);
			res.send(err);
		} else {
			res.json(regs);
		}
	});
});

//POST - Adiciona um registro
app.post("/api", function (req, res) {
	var autor = new Model({
		'nome' : req.body.nome,
		'email' : req.body.email,
    'abreviacao' : req.body.abreviacao,
    'ativo' : true,
	});
	autor.save(function (err) {
		if (err) {
			res.send(err);
			res.end();
		}
	});
	res.send(autor);
	res.end();
});


//PUT - Atualiza um registro
app.put("/api/:id", function (req, res) {
	Model.findByIdAndUpdate(req.params.id, req.body, function (err, post) {
    if (err)  {
    	return next(err);
    } else {
    	res.json(post);
    }
  });
});

//DELETE - Deleta um registro
app.delete("/api/:id", function (req, res) {
 Model.findByIdAndRemove(req.params.id, req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

//Porta de escuta do servidor
app.listen(8080, function() {
	console.log('Funcionando');
});
