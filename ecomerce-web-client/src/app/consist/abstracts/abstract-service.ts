import { HttpClient } from '@angular/common/http';
import { Apollo } from 'apollo-angular';
import { QuestionBase } from '../models/question-base';
import { TextboxQuestion } from '../models/textbox-question';
import { DropdownQuestion } from '../models/dropdown-question';
import { RadioQuestion } from '../models/radio-question';
// import { Apollo } from 'apollo-angular';

export class AbstractService<T> {

    constructor(protected http: HttpClient) { }

    search(apollo: Apollo, api: string, query: any): Promise<any> {
        return new Promise((resolve, reject) => {
            apollo.use(api).watchQuery(query).valueChanges.subscribe((response: any) => {
                resolve(response);
            }, reject);
        });
    }

    save(url: string, record: T, id?: string): Promise<any> {
        if (id) {
            return this.put(`${url}/${id}`, record);
        }
        return this.post(url, record);
    }

    sendJson(url: string, record: any, id?: string): Promise<any> {
        if (id) {
            return this.put(`${url}/${id}`, record);
        }
        return this.post(url, record);
    }

    toggleStatus(url: string, id: string): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.patch(`${url}/${id}`, {})
                .subscribe((response: any) => {
                    resolve(response);
                }, reject);
        });
    }

    remove(url: string, id: string): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.delete(`${url}/${id}`, {})
                .subscribe((response: any) => {
                    resolve(response);
                }, reject);
        });
    }

    post(url: string, record: T): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.post(url, record)
                .subscribe((response: any) => {
                    resolve(response);
                }, reject);
        });
    }

    get(url: string): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.get(url)
                .subscribe((response: any) => {
                    resolve(response);
                }, reject);
        });
    }

    patch(url: string, record: any): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.patch(url, record)
                .subscribe((response: any) => {
                    resolve(response);
                }, reject);
        });
    }

    put(url: string, record: T): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.put(url, record)
                .subscribe((response: any) => {
                    resolve(response);
                }, reject);
        });
    }


    getQuestions(form: any): QuestionBase<string>[] {
        const questions = new Array<QuestionBase<string>>();
        form.forEach(question => {
            let options: { key: string; value: string }[] = [];
            switch (question.controlType) {
                case 'textbox':
                    questions.push(
                        new TextboxQuestion({
                            key: question.key,
                            label: question.label,
                            type: question.type,
                            showLabel: question.showLabel,
                            placeholder: question.placeholder,
                            value: question.value ? question.value : null,
                            required: question.required,
                            order: question.order,
                            validators: question.validators,
                            cssClass: question.cssClass,
                            mask: question.mask
                        }));
                    break;

                case 'dropdown':
                    question.options.forEach(element => {
                        options.push({ key: element.key, value: element.value });
                    });
                    questions.push(
                        new DropdownQuestion({
                            key: question.key,
                            label: question.label,
                            type: question.type,
                            showLabel: question.showLabel,
                            placeholder: question.placeholder,
                            value: question.value ? question.value : null,
                            required: question.required,
                            order: question.order,
                            validators: question.validators,
                            cssClass: question.cssClass,
                            mask: question.mask,
                            options: options,
                            enum: question.enum,
                            multiple: question.multiple
                        }));
                    break;
                case 'radio':
                    question.options.forEach(element => {
                        options.push({ key: element.key, value: element.value });
                    });
                    questions.push(
                        new RadioQuestion({
                            key: question.key,
                            label: question.label,
                            type: question.type,
                            showLabel: question.showLabel,
                            placeholder: question.placeholder,
                            value: question.value ? question.value : null,
                            required: question.required,
                            order: question.order,
                            validators: question.validators,
                            cssClass: question.cssClass,
                            mask: question.mask,
                            options: options,
                            enum: question.enum,
                            multiple: question.multiple
                        }));
                    break;
            }
        });
        return questions.sort((a, b) => a.order - b.order);
    }


}
