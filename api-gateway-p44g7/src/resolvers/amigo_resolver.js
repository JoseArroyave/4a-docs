const AmigoResolver = {
    Query: {
        getbyCliente: (_, {}, { dataSources, }) => {
            dataSources.viajeAPI.getbyCliente(amigos)

        },
        Mutation: {
            createAmigo: (_, { amigos }, { dataSources, }) => {
                dataSources.viajeAPI.createAmigo(amigos)

            },
        }
    },
}
module.exports = AmigoResolver;