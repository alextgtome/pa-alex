import { QuestionBase } from 'src/app/consist/models/question-base';
import { TextboxQuestion } from 'src/app/consist/models/textbox-question';
import { ServiceProvidedTypeModel } from './service-provided-type-model';

export class ServiceProvidedModel {

    id: string;
    name: string;
    description: string;
    metadata: [String]
    endpoint: string;
    averageExecutionTime: number;
    serviceProvidedType: ServiceProvidedTypeModel;
    status: boolean;
    serviceImageOption: boolean;
    serviceQuestions: Array<QuestionBase<any>>;

    constructor(serviceProvidedModel?) {
        serviceProvidedModel = serviceProvidedModel || {};
        this.id = serviceProvidedModel.id || null;
        this.name = serviceProvidedModel.name || null;
        this.description = serviceProvidedModel.description || null;
        this.metadata = serviceProvidedModel.metadata || [];
        this.endpoint = serviceProvidedModel.endpoint || null;
        this.averageExecutionTime = Number(serviceProvidedModel.averageExecutionTime) || 1;
        this.status = serviceProvidedModel.status || true;
        this.serviceImageOption = serviceProvidedModel.serviceImageOption;
        this.serviceQuestions = this.getQuestions(serviceProvidedModel.serviceQuestions);
        this.serviceProvidedType = serviceProvidedModel.serviceProvidedType ? new ServiceProvidedTypeModel(serviceProvidedModel.serviceProvidedType): new ServiceProvidedTypeModel();
    }

    getQuestions(form: any): QuestionBase<string>[] {
        let questions = new Array<QuestionBase<string>>();

        form.forEach(question => {
            switch (question.controlType) {
                case 0:
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
            }
        });
        return questions;
    }

}
