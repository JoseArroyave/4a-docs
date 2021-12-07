//Se llama al typedef (esquema) de cada submodulo

const viajeTypeDefs = require('./viaje_type_defs');
const authTypeDefs = require('./auth_type_defs');
const conductorTypeDefs = require('./conductor_type_defs')
//Se unen
const schemasArrays = [authTypeDefs, viajeTypeDefs, conductorTypeDefs];
//Se exportan
module.exports = schemasArrays;