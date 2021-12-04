const viajeResolver = {
    Query: {
        getbyConductor: (_, { conductor }, { dataSources, }) => {
            dataSources.viajeAPI.getbyConductor(conductor)

        },
    Mutation: {
            createViaje: (_, { viaje }, { dataSources, }) => {
                dataSources.viajeAPI.createViaje(viaje)

            },
            terminarViaje: (_, { id }, { dataSources, }) => {

                dataSources.viajeAPI.terminarViaje(id)

            }
        }
    },
}
module.exports = viajeResolver;