import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {

    constructor(private router: Router) { }

    canActivate(): boolean {
        const session = JSON.parse(localStorage.getItem('session'));
        if (session !== null) {
            const token = session.token;
            const jwtDecode = require('jwt-decode');
            const isBeAbleTo = new Date() <= new Date(jwtDecode(token).exp * 1000);
            if (isBeAbleTo) {
                return true;
            } else {
                localStorage.removeItem('session');
                return false;
            }
        } else {
            this.router.navigate(['pages', 'login']);
            return false;
        }

    }

}
