export class Wallet {

    constructor(private _walletId:number, private _walletAmount:number, private _walletSource:String) {
    }
    set walletId(walletId:number){
    this._walletId = walletId;
    }
    
    get walletId():number{
        return this._walletId;
    }

    set walletAmount(walletAmount:number){
    this._walletAmount = walletAmount;
    }
        
    get walletAmount():number{
    return this._walletAmount;
    }

    set walletSource(walletSource:String){
        this._walletSource = walletSource;
    }
            
    get walletSource():String{
    return this._walletSource;
    }
    
}