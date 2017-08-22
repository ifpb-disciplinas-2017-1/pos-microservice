var mongo = require('mongoose'),
Model = mongo.model('Autor');

exports.findAll = function(req, res){
  var autorProjection = {
      __v: false,
      _id: false,
      ativo: false,
      updated_at: false
  };
  Model.find({}, autorProjection, function(err, todos) {
      if (err) return next(err);
      res.json(todos);
 })
};

exports.findByName = function(req, res){
  var nome = req.params.nome;
  Model.find({'nome': nome}, function(err, regs) {
		 if (err) res.send(err);
		 else res.json(regs);
	});
};

exports.update = function(req, res) {
  var id = req.params.id;
  var updates = req.body;
  Model.findByIdAndUpdate(id, updates, function (err, post) {
    if (err) return next(err);
    else res.json(post);
  });
}

exports.add = function(req, res) {
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
  res.send(201, autor);
  res.end();
}

exports.delete = function(req, res){
  var id = req.params.id;
  var body = req.body;
  Model.findByIdAndRemove(id, body, function (err, post) {
     if (err) return next(err);
     res.json(post);
  });
};
