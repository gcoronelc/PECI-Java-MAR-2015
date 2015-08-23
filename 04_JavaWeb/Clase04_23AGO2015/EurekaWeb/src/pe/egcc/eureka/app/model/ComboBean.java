package pe.egcc.eureka.app.model;

public class ComboBean {
  
  private String value;
  private String label;
  private String select;
  
  public ComboBean() {
  }

  public ComboBean(String value, String label, String select) {
    super();
    this.value = value;
    this.label = label;
    this.select = select;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getSelect() {
    return select;
  }

  public void setSelect(String select) {
    this.select = select;
  }
  
  

}
