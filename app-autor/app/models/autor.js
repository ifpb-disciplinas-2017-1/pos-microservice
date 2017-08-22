var mongo = require('mongoose'),
  Schema = mongo.Schema;

var autorSchema = new Schema({
  nome : { type: String },
  email : { type: String },
  abreviacao : { type: String },
	ativo : Boolean,
	updated_at: { type: Date, default: Date.now }
});

mongo.model('Autor', autorSchema);
