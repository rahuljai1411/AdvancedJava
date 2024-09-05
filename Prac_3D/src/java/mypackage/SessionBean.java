
package mypackage;

import javax.ejb.Stateless;


@Stateless
public class SessionBean {
    public SessionBean(){}
    public double r2d(double r){return r/83.91;}
    public double d2r(double d){return d*83.91;}
   
}
