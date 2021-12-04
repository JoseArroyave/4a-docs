//Se llama al typedef (esquema) de cada submodulo
const amigoTypeDefs = require('./amigo_type_defs');
const viajeTypeDefs = require('./viaje_type_defs');
const conductorTypeDefs = require('./conductor_type_defs');
//Se unen
const schemasArrays = [,viajeTypeDefs];
//Se exportan
module.exports = schemasArrays;