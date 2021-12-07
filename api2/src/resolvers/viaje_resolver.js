const viajeResolver = {
    Query: {
        getByConductor: async (_, { conductor }, { dataSources, }) => {
            return await dataSources.viajeAPI.getByConductor(conductor)

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