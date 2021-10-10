
export class Login {

    identification: string;
    password: string;
    accessType: string;

    constructor(login?) {
        login = login || {};
        this.identification = login.identification || '';
        this.password = login.password || '';
        this.accessType = 'CLIENT';
    }

}
