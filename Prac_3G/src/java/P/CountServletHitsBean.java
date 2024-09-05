package P;

import javax.ejb.Singleton;


@Singleton
public class CountServletHitsBean {
        private int hitcount;
        public synchronized int incremetnAndGetHitCount(){
            return hitcount++;
        }
    
}
