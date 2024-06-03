package ntu.ngtuantu.test;

import android.database.Cursor;
import android.os.Bundle;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cau4Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cau4Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cau4Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cau4Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Cau4Fragment newInstance(String param1, String param2) {
        Cau4Fragment fragment = new Cau4Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//                //        // Bước 0. Tạo file cơ sở dữ liệu
//        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db", // tên file = tên DB
//                                                    Context.MODE_PRIVATE,  // giới hạn truy cập
//                                                     null          // con trỏ bản ghi
//                                                 );
//        // B1. Tạo bảng
//          // câu lêệnh tạo bảnga
//        String sqlXoaBangNeuDaCo="DROP TABLE IF EXISTS Books;";
//
//        String sqlTaoBang = "CREATE TABLE Books( BookID integer PRIMARY KEY, " +
//                                                "BookName text, " +
//                                                "Page integer, " +
//                                                "Price Float, " +
//                                                "Description text);";
//            // thực hiện lệnh sql
//        db.execSQL(sqlXoaBangNeuDaCo);
//        db.execSQL(sqlTaoBang);
//        // Thêm một số dòng dữ liệu vào bảng
//        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
//        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
//        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
//        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');";
//        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);
//        db.execSQL(sqlThem4);
//        db.execSQL(sqlThem5);
//        // Để quan sát trực quan file .db ? ==> Dùng ứng dụng DB Browser for SQLite
//        // Để mở được, ta file save file từ điện thoại ra đĩa cứng
//
//        // Ta đóng lại để check
//        db.close();
        //B1. Mở CSDL
        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db", // tên file = tên DB
                Context.MODE_PRIVATE,  // giới hạn truy cập
                null          // con trỏ bản ghi
        );
        //B2. Thực thi câu lệnh select
        String sqlSelect ="Select * from Books;";
        Cursor cs = db.rawQuery(sqlSelect,null);
        cs.moveToFirst(); // đưa con trỏ bản ghi về hàng đầu tiên

        // B3: Đổ vào biến nào đó để xử lý
        // 3.1. Xây dựng model/class cho bảng Books, vi dụ: Book.java
        // 3.2. Tạo biến ArrayList<Book> dsSach;
        ArrayList<Book> dsSach = new ArrayList<Book>();
        //3.3. Duyệt qua lần lượt từng bản ghi và thêm vào danhSach
        while (cs.moveToNext()) // còn bản ghi để chuyển tới
        {
            // Lấy dữ liệu từng cột ở dòng hiện tại
            int idSach = cs.getInt(0);  // lấy dữ liệu ở côt 0, kiểu int
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);
            // Tạo một đối tượng sách và thêm vào danh sách
            Book b = new Book(idSach,tenSach,soTrang,gia,mota);
            dsSach.add(b);
        }
        //B4, Hiện lên listview, recylerview,..
        // để cho nhanh, ở đây thầy chỉ hiện tên sách
        ArrayList<String> dsTenSach = new ArrayList<String>();
        for (int i=0; i<dsSach.size(); i++ )
            dsTenSach.add(dsSach.get(i).getBookName());
        // Hiển thị lên đk Listview
        // Inflate the layout for this fragment
        View viewCau4= inflater.inflate(R.layout.fragment_cau4, container, false);

        ListView listViewTenSach = viewCau4.findViewById(R.id.lvTenSach);
        ArrayAdapter<String> adapterTenSach = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                dsTenSach
        );
        listViewTenSach.setAdapter(adapterTenSach);
        // Lắng nghè va xl

        return viewCau4;
    }
}