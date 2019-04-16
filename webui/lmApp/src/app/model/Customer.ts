export class Customer {
    constructor(private _CusId:number, private _CusName:string, private _CusPhoneNo:string, private _CusEmail:string, 
                private _CusPassword:string, private _CusUserName:string) { }

    set CusId(cusId:number) {
        this._CusId = cusId;
    }
    get CusId():number {
        return this._CusId;
    }

    set CusName(cusName:string) {
        this._CusName = cusName;
    }
    get CusName():string {
        return this._CusName;
    }

    set CusPhoneNo(cusPhoneNo:string) {
        this._CusPhoneNo = cusPhoneNo;
    }
    get CusPhoneNo():string {
        return this._CusPhoneNo;
    }
    set CusEmail(cusEmail:string) {
        this._CusEmail = cusEmail;
    }
    get CusEmail():string {
        return this._CusEmail;
    }
    set CusPassword(CusPassword:string) {
        this._CusPassword = CusPassword;
    }
    get CusPassword():string {
        return this._CusPassword;
    }

    set CusUserName(cusUserName:string) {
        this._CusUserName = cusUserName;
    }
    get CusUserName():string {
        return this._CusUserName;
    }
}