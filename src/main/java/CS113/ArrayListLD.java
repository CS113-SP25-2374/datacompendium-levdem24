package CS113;

public class ArrayListLD<E> implements ListInterface<E>{
    private E[] array;
    //private int count;
    final static int DEFAULT_SIZE = 10;

    public ArrayListLD(){
        array = (E[]) new Object[DEFAULT_SIZE];
    }

    private void resize(){
        E[] resizeArray = (E[]) new Object[array.length + (array.length / 2)];
        for(int i = 0; i < array.length; i++){
            resizeArray[i] = array[i];
        }
        array = resizeArray;
    }
    @Override
    public boolean add(E element) {
        if(array[array.length - 1] != null){
            int length = array.length;
            resize();
            array[length] = element;
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                array[i] = element;
                return true;
            }
        }
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > array.length){
            throw new IndexOutOfBoundsException();
        }
        if(array[array.length - 1] != null){
            resize();
        } else if(index == array.length - 1){
            array[array.length - 1] = element;
        }

        for(int i = index; i < array.length; i++){
            E temp = array[i + 1];
            array[i + 1] = array[i];
            array[i] = element;
            element = temp;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }

        for(E element : array){
            element = null;
        }

    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(Object object) {
        if(object == null){
            return -1;
        }
        for(int i=0; i < array.length; i++){
            if(Object.equals(array[i])){
                return 1;
            }

        }
        return -1;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= array.length){
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        return true;

    }

    @Override
    public boolean remove(Object element) {
        int index = indexOf(element);
        return remove(index);

    }

    @Override
    public int size() {
        for (int i = array.length - 1; i >= 0; i--){
            if (array[i] != null){
                return i+1;
            }
        }
       return 0;
    }

    @Override
    public void set(int index, Object element) {

    }
}
