import java.util.ArrayList;


public abstract class ResourcePool <R extends Resource> {

	private ArrayList<R> poolFree;
	private ArrayList<R> poolUsed;
	
	public ResourcePool(int n){
		this.poolFree= new ArrayList<R>(n);
		this.poolUsed = new ArrayList<R>(n);
		for(int i=0;i<n;i++){
			poolFree.add(createResource());
		}
	}
	
	public R provideResource(){
		if(hasAvailableResource()){
			R r = poolFree.get(0);
			poolFree.remove(0);
			poolUsed.remove(0);
		}
		return null;
	}
	
	private boolean hasAvailableResource() {
		// TODO Auto-generated method stub
		if(this.poolFree.get(0)== null){
			return false;
		}else{
			return true;
		}
	}

	public void freeResource(R r){
		int indexResourceUsed=this.poolUsed.indexOf(r);
		if(indexResourceUsed!=-1){
			this.poolUsed.remove(indexResourceUsed);
			this.poolFree.add(r);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	protected abstract R createResource();
	
}
