package com.gjiazhe.wavesidebar.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjiazhe.wavesidebar.Contact;
import com.gjiazhe.wavesidebar.ListSort;
import com.gjiazhe.wavesidebar.WaveSideBar;

import java.util.ArrayList;

public class RightPositionActivity extends AppCompatActivity {

    private RecyclerView rvContacts;
    private WaveSideBar sideBar;
   private ContactsAdapter contactsAdapter;
    private ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();
    }


    private void initView() {
        setContentView(R.layout.activity_contacts);
        rvContacts = (RecyclerView) findViewById(R.id.rv_contacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        contactsAdapter=new ContactsAdapter(contacts, R.layout.item_contacts);
        rvContacts.setAdapter(contactsAdapter);
        sideBar = (WaveSideBar) findViewById(R.id.side_bar);
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) rvContacts.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });
    }

    String arr[] = new String[]{"wangqi", "wangqi1","WANG", "擦", "的", "*", "飞", "个", "和", "i", "就",
            "看", "了", "吗", "150", "哦", "平", "a", "@", "是", "他", "u", "v", "我", "想", "一", "在"
    };

    private void initData() {
        for (int i = 0; i < arr.length; i++) {
            Contact contact = new Contact();
            contact.setName(arr[i]);
            contact.setIndex(ListSort.HanziToPinyin(arr[i]));
            contacts.add(contact);
        }
        ListSort.listSort(contacts);
    }
}
