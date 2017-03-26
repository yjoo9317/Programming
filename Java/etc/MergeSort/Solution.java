
public void mergeSort(int low, int high, int[] input){
  if(low >= high) return;
  int middle = (low+high)/2;
  mergeSort(low, middle, input);
  mergeSort(middle+1, high, input);
  merge(low, high, input);
}

private void merge(int low, int high, int[] input){
  for(int i = 0; i < input.length; i++){
    temp[i] = input[i];
  }

  int left = low;
  int right = middle+1;
  int idx = low;
  while(left <= middle && right <= high){
    if(temp[left] <= temp[right]){
      input[idx++] = temp[left++];
    } else {
      input[idx++] = temp[right++];
    }
  }
  int until = middle-left;
  for(int i = 0; i <= until; i++){
    input[idx+i] = temp[left+i];
  }
}
