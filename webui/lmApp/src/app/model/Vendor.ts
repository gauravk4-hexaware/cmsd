export class Vendor{
    constructor(private _VenId:number, private _VenName:string, private _VenPhoneNo:string, private _VenUsername:string,
        private _VenPassword:string, private _VenBalance:number, private _CusId:number, private _Price:number) {
    }
    set Price(Price:number){
        this._Price = Price;
    }
    get Price():number {
        return this._Price;
    }
    set CusId(CusId:number){
        this._CusId = CusId;
    }
    get CusId():number {
        return this._CusId;
    }
    set VenId(VenId:number){
        this._VenId = VenId;
    }
    get VenId():number {
        return this._VenId;
    }
    set VenName(VenName:string) {
        this._VenName = VenName;
    }
    get VenName():string {
        return this._VenName;
    }
    set VenPhoneNo(VenPhoneNo:string) {
        this._VenPhoneNo = VenPhoneNo;
    }
    get VenUsername():string {
        return this._VenUsername;
    }
    set VenPassword(VenPassword:string) {
        this._VenPassword = VenPassword;
    }
    get VenPassword() {
        return this._VenPassword;
    }
    set VenBalance(VenBalance:number) {
        this._VenBalance = VenBalance;
    }
    get VenBalance():number {
        return this._VenBalance;
    }


}