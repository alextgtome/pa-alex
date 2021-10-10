// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {

  registrOfficer: 'santana',
  production: false,
  instagram_token: 'dd03e8c73c9401dfe02562c646f81411',
  stripe_token: 'STRIPE_PUBLISHABLE_KEY',
  paypal_token: 'PAYPAL_CLIENT_ID',

  endpoint: 'http://localhost:8000',
  authentication: '/authentication/v1',
  accounts: '/accounts/v1',
  services: '/services/v1',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
