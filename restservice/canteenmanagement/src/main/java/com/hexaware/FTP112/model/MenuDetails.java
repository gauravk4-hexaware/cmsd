package com.hexaware.FTP112.model;

import java.util.Objects;


/**
 */
public class MenuDetails {
  private int menId;
  private int venId;
  private double menPrice;
  private int ratings;
  private String reviews;
  private String venName;
  private String venPhnNo;

  /**
   * Default Constructor.
   */
  public MenuDetails() {

  }

  /**
   * @param argMenId to initialize menu id.
   * @param argVenId to initialize vendor id.
   * @param argMenPrice to initialize menuPrice number.
   * @param argRatings to initialize ratings.
   * @param argReviews to initialize reviews.
     */
  public MenuDetails(final int argMenId, final int argVenId, final double argMenPrice, final int argRatings, final String argReviews) {
    this.menId = argMenId;
    this.venId = argVenId;
    this.menPrice = argMenPrice;
    this.ratings = argRatings;
    this.reviews = argReviews;
  }
   /**
   * @param argVenId to initialize vendor id.
   * @param argRatings to initialize ratings.
   * @param argReviews to initialize reviews.
   * @param argMenPrice to initialize menuPrice number.
   * @param argVenName to initialize vendorName.
   * @param argVenPhnNo to initialize vendor phone number.
     */
  public MenuDetails(final int argVenId, final int argRatings,
                        final String argReviews, final double argMenPrice,
                        final String argVenName, final String argVenPhnNo) {
    this.venId = argVenId;
    this.ratings = argRatings;
    this.reviews = argReviews;
    this.menPrice = argMenPrice;
    this.venName = argVenName;
    this.venPhnNo = argVenPhnNo;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    MenuDetails menuDetails = (MenuDetails) obj;
    if (Objects.equals(menId, menuDetails.getMenId())
            && Objects.equals(venId, menuDetails.getVenId())
            && Objects.equals(menPrice, menuDetails.getMenPrice())
            && Objects.equals(ratings, menuDetails.getRatings())
            && Objects.equals(reviews, menuDetails.getReviews())) {
      return true;
    }
    return false;
  }

  @Override
    public final int hashCode() {
    return Objects.hash(menId, venId, menPrice, ratings, reviews);
  }

  /**
    * @return this menu id .
    */
  public final int getMenId() {
    return menId;
  }
  /**
    * @return this ven id .
    */
  public final int getVenId() {
    return venId;
  }
  /**
    * @return this menu price .
    */
  public final double getMenPrice() {
    return menPrice;
  }
  /**
    * @return this ven ratings.
    */
  public final int getRatings() {
    return ratings;
  }
  /**
    * @return this ven reviews .
    */
  public final String getReviews() {
    return reviews;
  }
  /**
    * @return this vendor name.
    */
  public final String getVenName() {
    return venName;
  }
  /**
    * @return this ven phone no .
    */
  public final String getVenPhnNo() {
    return venPhnNo;
  }
  /**
    * @param argMenuId gets the food id.
    */
  public final void setMenId(final int argMenuId) {
    this.menId = argMenuId;
  }
  /**
    * @param argVenId gets the vendor id.
    */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
  /**
    * @param argMenPrice gets the menu price.
    */
  public final void setMenPrice(final double argMenPrice) {
    this.menPrice = argMenPrice;
  }
  /**
    * @param argRatings gets the ratings.
    */
  public final void setRatings(final int argRatings) {
    this.ratings = argRatings;
  }
  /**
    * @param argReviews gets the reviews.
    */
  public final void setReviews(final String argReviews) {
    this.reviews = argReviews;
  }
  /**
    * @param argVenPhnNo gets the vendor phone no.
    */
  public final void setVenPhnNo(final String argVenPhnNo) {
    this.venPhnNo = argVenPhnNo;
  }
  /**
    * @param argVenName gets the vwndor name.
    */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
}
