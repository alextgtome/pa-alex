import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { Apollo, ApolloModule } from 'apollo-angular';
import { HttpLink, HttpLinkModule } from 'apollo-angular-link-http';
import { InMemoryCache } from 'apollo-cache-inmemory';
import { setContext } from 'apollo-link-context';
import { DefaultOptions } from 'apollo-client';
import { environment } from 'src/environments/environment';

@NgModule({
  imports: [
    HttpClientModule,
    ApolloModule,
    HttpLinkModule
  ]
})
export class GraphQLModule {

  private readonly AUTHENTICATION: string = environment.endpoint + environment.authentication + '/graphql';
  private readonly SERVICES: string = environment.endpoint + environment.services + '/graphql';
  private readonly ACCOUNTS: string = environment.endpoint + environment.accounts + '/graphql';
  private readonly TESTE: string = "http://localhost:8500/v1" + '/graphql';

  authLink = setContext((_, { headers }) => {
    // get the authentication token from local storage if it exists
    const token = JSON.parse(localStorage.getItem('session')).token;
    // return the headers to the context so httpLink can read them
    return {
      headers: {
        ...headers,
        Authorization: token ? `Bearer ${token}` : "",
      }
    }
  });
  defaultOptions: DefaultOptions = {
    watchQuery: {
      fetchPolicy: 'no-cache',
      errorPolicy: 'ignore',
    },
    query: {
      fetchPolicy: 'no-cache',
      errorPolicy: 'all',
    },
  }


  constructor(
    apollo: Apollo,
    httpLink: HttpLink
  ) {
    const options1: any = { uri: this.AUTHENTICATION };
    apollo.createDefault({
      link: httpLink.create(options1),
      cache: new InMemoryCache(),
      defaultOptions: this.defaultOptions,

    });

    const options2: any = { uri: this.SERVICES };
    apollo.createNamed('services', {
      link: httpLink.create(options2),
      cache: new InMemoryCache(),
      defaultOptions: this.defaultOptions,
    });
    const options3: any = { uri: this.ACCOUNTS };
    apollo.createNamed('accounts', {
      link: httpLink.create(options3),
      cache: new InMemoryCache(),
      defaultOptions: this.defaultOptions,
    });
    const options4: any = { uri: this.TESTE };
    apollo.createNamed('teste', {
      link: httpLink.create(options4),
      cache: new InMemoryCache(),
      defaultOptions: this.defaultOptions,
    });
  }
}
