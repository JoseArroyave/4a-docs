const authResolver = require('./auth_resolver');
const viajeResolver = require('./viaje_resolver');
const conductorResolver = require('./conductor_resolver');
const lodash = require('lodash');

const resolvers = lodash.merge(viajeResolver, authResolver, conductorResolver);
module.exports = resolvers;