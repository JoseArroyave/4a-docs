const viajeResolver = {
    Query: {
        getByConductor: async (_, { conductor }, { dataSources, }) => {
            return await dataSources.viajeAPI.getByConductor(conductor)

        },
        getByCliente: async (_, { }, { dataSources, }) => {
            return await dataSources.viajeAPI.getByCliente()

        },

    },
    Mutation: {
            createViaje: (_, { viaje }, { dataSources, }) => {
                dataSources.viajeAPI.createViaje(viaje)

            },
            terminarViaje: async (_, { id }, { dataSources, }) => {

                return await dataSources.viajeAPI.terminarViaje(id)

            },
        },
    }

    
module.exports = viajeResolver;