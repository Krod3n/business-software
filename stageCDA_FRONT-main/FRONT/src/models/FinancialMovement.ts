export default class FinancialMovement {
    id: number;
    description: string;
    date: string;
    thirdParty: string;
    amount: number;
    paymentMode: string;

    constructor(
        id: number,
        description: string,
        date: string,
        thirdParty: string,
        amount: number,
        paymentMode: string,
    ) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.thirdParty = thirdParty;
        this.amount = amount;
        this.paymentMode = paymentMode;

    }


}