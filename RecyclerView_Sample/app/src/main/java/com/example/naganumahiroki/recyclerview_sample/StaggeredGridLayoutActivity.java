package com.example.naganumahiroki.recyclerview_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naganumahiroki on 2015/09/24.
 *
 * 大きさの変化するレイアウト
 *
 */
public class StaggeredGridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        // リストのレイアウトサイズが動的に変わらず固定されている場合、
        // setHasFixedSize()にtrueを設定すると、パフォーマンスが向上します。今回はレイアウトサイズが動的に変わることはありません。

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        // レイアウトマネージャーをRecyclerViewに設定しています。
        // RecyclerViewを使う場合は、レイアウトマネージャーを必ず設定する必要があります。
        // １行リストを表示する場合は、LinearLayoutManagerを設定します。

        final List list = new ArrayList();

        list.add("Single line layout");
        list.add("Grid layout");
        list.add("Staggered gridLayout layout");
        for (int i = 0; i < 30; i++) {
            list.add("item" + i);
        }
        // データを生成し、アダプターに設定しています。
        // RecyclerAdapterクラスはRecyclerView.Adapterクラスを継承した自作クラスです。
        // ここではMainActivityクラス内に内部クラスとして宣言しています。
        recyclerView.setAdapter(new SingleRecyclerAdapter(getApplicationContext(), list));
    }
}