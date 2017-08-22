module.exports = function(app){

	var autor = require('./controllers/autores');
	app.get('/autor', autor.findAll);
	app.get('/autor/:nome?', autor.findByName);
  app.put('/autor/:id', autor.update);
  app.post('/autor', autor.add);
  app.delete('/autor/:id', autor.delete);

	app.get('/', function(req, res) {
	    res.send('app online\n');
	});
};
