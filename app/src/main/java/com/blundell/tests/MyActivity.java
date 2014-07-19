package com.blundell.tests;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MyActivity extends Activity {

    private static final List<String> items = Arrays.asList("Apple", "Orange", "Plum", "Pear", "Melon", "Peach", "Grape");

    private TextView textView;
    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        textView = (TextView) findViewById(R.id.my_hello_text_view);
        list = (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        list.setOnItemClickListener(onListItemClick);
        findViewById(R.id.my_button).setOnClickListener(onMyButtonClick);
    }

    private final AdapterView.OnItemClickListener onListItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String selectedListItem = items.get(position);
            textView.setText(selectedListItem);
        }
    };

    private final View.OnClickListener onMyButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            list.setAdapter(adapter);
        }
    };
}
