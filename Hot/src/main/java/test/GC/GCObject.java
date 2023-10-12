package test.GC;

/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/10/12 11:02
 */
public class GCObject {
    public Object ref;
    public boolean marked;

    public GCObject(){};
    public GCObject(Object ref) {
        this.ref = ref;
    }

    public Object getRef() {
        return ref;
    }

    public GCObject copy() {
        GCObject copy = new GCObject();
        copy.marked = this.marked;
        copy.ref = this.ref;
        return copy;
    }

    public GCObject getForwardedObject() {
        if (ref instanceof GCObject) {
            GCObject forwardedObj = (GCObject) ref;
            if (forwardedObj == this) {
                return this;
            }
            return forwardedObj.getForwardedObject();
        } else {
            return this;
        }
    }
}