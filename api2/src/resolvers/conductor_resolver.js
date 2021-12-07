const conductorResolver = {
    Query: {
        getConductor: async (_, { cedula }, { dataSources, }) => {
            return await dataSources.viajeAPI.getConductor(cedula)
        },
        getDisponibles: async (_, { }, { dataSources, }) => {
            return await dataSources.viajeAPI.getDisponibles()
        },
        getElegido: async (_, { }, { dataSources, }) => {
            return await dataSources.viajeAPI.getElegido()
        },
    },
    Mutation: {
        createConductor: (_, { conductor }, { dataSources, }) => {
                dataSources.viajeAPI.createConductor(conductor)

            },

        },
    }

    
module.exports = conductorResolver;