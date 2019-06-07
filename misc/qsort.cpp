#include <iostream>


using namespace std;

static int count = 0;
int partition(int*, int, int);

  // Recursive quick sort function
  void QSort(int* data, int lo, int hi)
  {
    if (lo < hi)
    {
      // the pivot's final location
      int p = partition(data, lo, hi);

      // the two segments that the algorithm recurs on are
      // (lo..p-1) and (p..hi) for the rightmost pivot
      // (lo..p) and (p+1..hi) for the leftmost pivot
      QSort(data, lo, p - 1);
      QSort(data, p, hi);
    }
  }

  // Partitioning step of quick sort
  int partition(int* data, int lo, int hi)
  {
    // Choose the rightmost pivot
    int pivot = data[hi];
    int i = lo - 1;
    int j = hi + 1;
    while (true)
    {
      do
        i++;
      while (data[i] < pivot);

      do
        j--;
      while (data[j] > pivot);

      if (i >= j)
        return i; // return i for the rightmost pivot
        //return j;  // return j for the leftmost pivot

      std::swap(data[i], data[j]);
    }
  }

void quicksort(int* A, int p, int q) {
  if (p < q) {
    int M = A[q];
    int j = p;
    for (int k = p; k < q; k++) {
      if (A[k] < M) {
        int x = A[j];
        A[j] = A[k];
        A[k] = x;
        j++;
      }
      count++;
    }
    A[q] = A[j];
    A[j] = M;

    quicksort(A, p, j-1);
    quicksort(A, j+1, q);
  }
}

int main()
{
  //int data[] = {11,13,12,32,31,33,20};
  //int data[] = {33,32,31,20,13,12,11};
  //int data[] = {1,3,2,5,7,6,4,9,11,10,13,15,14,12,8};
  int data[] = {1,3,2,6,5,7,4,12,9,11,10,14,13,15,8};
//  cout << "Hello world";
//  QSort(data, 0, 6);
  quicksort(data, 0, 14);
  for ( int i : data)
    cout << i << endl;
  
  cout << "Count = " << count;

  return 0;
}
