const { gql } = require('apollo-server');

const authTypeDefs = gql `
type Tokens {
    refresh: String!
    access: String!
}
type Access {
    access: String!
}
input CredentialsInput {
    username: String!
    password: String!
}
input SignUpInput {
    username: String!
    password: String!
    name: String!
    email: String!
    
}
type Mutation {
    signUpUser(userInput :SignUpInput): Tokens!
    logIn(credentials: CredentialsInput!): Tokens!
    refreshToken(refresh: String!): Access!
}
    `;

module.exports = authTypeDefs;