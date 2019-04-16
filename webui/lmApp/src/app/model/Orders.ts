export class Orders {
    constructor(private _OrdId:number, private _CusId:number,  private _VenName:string, private _VenId:number, private _TotaltOrderPrice:number,
        private _OrderStatus:string, private _OrderComments:string, private _OrdDate:number, private _WalId:number,  private _walletSource:String){
        }
        set OrdId(OrdId:number){
            this._OrdId=OrdId;
        }
        get OrdId():number{
            return this._OrdId;
        }
        set CusId(CusId:number){
            this._CusId=CusId;
        }
        get CusId():number{
            return this._CusId;
        }
        set VenName(VenName:string) {
            this._VenName = VenName;
        }
        get VenName():string {
            return this._VenName;
        }
        set VenId(VenId:number){
            this._VenId=VenId;
        }
        get VenId():number{
            return this._VenId;
        }
        set TotalOrderPrice(TotalOrderPrice:number){
            this._TotaltOrderPrice=TotalOrderPrice;
        }
        get TotalOrderPrice():number{
            return this._TotaltOrderPrice;
        }
        set OrderStatus(OrderStatus:string){
            this._OrderStatus=OrderStatus;
        }
        get OrderStatus():string{
            return this._OrderStatus;
        }
        set OrderComments(OrderComments:string){
            this._OrderComments=OrderComments;
        }
        get OrderComments():string{
            return this._OrderComments;
        }
        set OrdDate(OrdDate:number){
            this._OrdDate=OrdDate;
        }
        get OrdDate():number{
            return this._OrdDate;
        }
        set WalId(WalId:number){
            this._WalId=WalId;
        }
        get WalId():number{
            return this._WalId ;
        }
        set walletSource(walletSource:String){
            this._walletSource = walletSource;
        }
                
        get walletSource():String{
        return this._walletSource;
        }
}