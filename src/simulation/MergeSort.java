package simulation;


public class MergeSort {

    // Melakukan merge sort tetapi hasil akhirnya adalah urutan menurun (descending).
    // Merge Sort bekerja dengan pola:
    //  1. Divide  -> membagi array menjadi dua bagian
    //  2. Sort    -> mengurutkan kedua bagian (rekursif)
    //  3. Merge   -> menggabungkan dua array terurut menjadi satu array besar
    //return    Array baru yang sudah terurut dari terbesar -> terkecil

   public static int[] sortDescending(int[] arr) {
       // Jika panjang array 0 atau 1, maka sudah pasti terurut.
       if (arr.length <= 1) return arr;
       // Menentukan titik tengah array untuk dipisah dua bagian.
       int mid = arr.length / 2;

       // Menyiapkan array sisi kiri dan sisi kanan.
       int[] left = new int[mid];
       int[] right = new int[arr.length - mid];

        //Menyalin elemen ke:
        // left  -> dari index 0 ... mid-1
        // right -> dari index mid ... akhir
       System.arraycopy(arr, 0, left, 0, mid);
       System.arraycopy(arr, mid, right, 0, arr.length- mid);

       //Rekursif -> mengurutkan dua bagian secara terpisah.
       left = sortDescending(left);
       right = sortDescending(right);

       //Setelah kedua bagian terurut, gabungkan sambil tetap descending order.
       return mergeDesc(left, right);
   }

    // Menggabungkan dua array yang SUDAH terurut descending menjadi satu array descending.
    //
    //left  Array kiri (sudah urut descending)
    //right Array kanan (sudah urut descending)
    //return Array hasil gabungan (descending)

   private static int[] mergeDesc(int[] left, int[] right) {
       // Array final dengan ukuran total gabungan.
       int[] merged = new int[left.length + right.length];

       // i -> pointer untuk left
       // j -> pointer untuk right
       // k -> pointer untuk merged
       int i = 0, j = 0, k = 0;


        //Selama kedua pointer masih dalam batas array:
        //- Ambil nilai paling besar (descending)
        //- Masukkan ke merged[]
        //
       while (i<left.length && j < right.length) {
           // Dibalik dari ascending: left[i] >= right[j] agar besar duluan
           if (left[i] >= right[j]) {
               merged[k++] = left[i++];
           } else {
               merged[k++] = right[j++];
           }
       }

       //Jika left masih punya sisa elemen -> masukkan semuanya
       while(i<left.length){
           merged[k++] = left[i++];
       }

       //Jika right masih punya sisa elemen -> masukkan semuanya
       while(j<right.length){
           merged[k++] = right[j++];
       }
       //Kembalikan array hasil merge
       return merged;
   }
}

