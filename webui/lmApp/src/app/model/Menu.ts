export class Menu {

  constructor(private _MenuId:number, private _MenItem:String,private _MenCalories:number,private _VenId:number,
      private _Ratings:number, private _Reviews:String, private _MenPrice:number, private _OrdId:number,
      private _OrderItemId:number, private _Qty:number, private _VenName:String, private _MenSpeciality:String) {
  }
          set MenuId(MenuId:number){
           this._MenuId = MenuId;
          }
  
         get MenuId():number{
          return this._MenuId;
         }
         set MenSpeciality(MenSpeciality:String){
          this._MenSpeciality= MenSpeciality;
         }
  
        get MenSpeciality():String{
         return this._MenSpeciality;
        }
         set OrdId(OrdId:number){
          this._OrdId = OrdId;
         }
  
        get OrdId():number{
         return this._OrdId;
        }
        set MenItem(MenItem:String){
          this._MenItem= MenItem;
         }
  
        get MenItem():String{
         return this._MenItem;
        }
  
        set Reviews(Reviews:String){
          this._Reviews= Reviews;
         }
  
        get Reviews():String{
         return this._Reviews;
        }
  
        set OrdItemId(OrderItemId:number){
          this._OrderItemId = OrderItemId;
         }
  
        get OrdItemId():number{
         return this._OrderItemId;
        }
        set Qty(Qty:number){
          this._Qty = Qty;
         }
  
        get Qty():number{
         return this._Qty;
        }
  
         set MenCalories(MenCalories:number){
          this._MenCalories = MenCalories;
         }
  
         get MenCalories():number{
          return this._MenCalories;
         }
  
         set VenId(VenId:number){
          this._VenId = VenId;
         }
  
        get VenName():String{
         return this._VenName;
        }
        set VenName(VenName:String){
          this._VenName = VenName;
         }
  
        get VenId():number{
         return this._VenId;
        }
  
        set Ratings(Ratings:number){
          this._Ratings = Ratings;
         }
  
        get Ratings():number{
         return this._Ratings;
        }
  
  
        set MenPrice(MenPrice:number){
          this._MenPrice = MenPrice;
         }
  
        get MenPrice():number{
         return this._MenPrice;
        }
  
  }