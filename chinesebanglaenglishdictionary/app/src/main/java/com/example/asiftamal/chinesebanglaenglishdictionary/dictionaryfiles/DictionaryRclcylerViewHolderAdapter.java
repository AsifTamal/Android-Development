package com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import static com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles.DictionaryRclcylerViewHolderAdapter.clickListenerWordRV;
import static com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles.DictionaryRclcylerViewHolderAdapter.item_DicWordDetail;
import com.example.asiftamal.chinesebanglaenglishdictionary.R;


import java.util.ArrayList;
import java.util.List;

public class DictionaryRclcylerViewHolderAdapter extends RecyclerView.Adapter<DictionaryRecycleViewHolder> implements Filterable {

    private Context context;
    public static ClickListenerWordRV clickListenerWordRV;
   public static ArrayList<DictionaryDetailcls> item_DicWordDetail;
   private List<DictionaryDetailcls> item_DicWordDetailfullList;

    public DictionaryRclcylerViewHolderAdapter(Context context, ArrayList<DictionaryDetailcls> item_DicWordDetail) {
        this.context = context;
        this.item_DicWordDetail = item_DicWordDetail;
        item_DicWordDetailfullList=new ArrayList<>(item_DicWordDetail);
    }

//bring the cardview to show inside recycler view
    @NonNull
    @Override
    public DictionaryRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.word_cardview_for_recycler_list,viewGroup,false);

        return new DictionaryRecycleViewHolder(view);
    }
//bind data with the cardview to show in the recyclerview
    @Override
    public void onBindViewHolder(@NonNull DictionaryRecycleViewHolder dictionaryRecycleViewHolder, int i) {
        dictionaryRecycleViewHolder.txtWordId.setText(Integer.toString(item_DicWordDetail.get(i).getWordID()));
        dictionaryRecycleViewHolder.txt_EnglishWord.setText("English-> "+item_DicWordDetail.get(i).getEnglishword());
        dictionaryRecycleViewHolder.txt_Banglaword.setText("Bangla-> "+item_DicWordDetail.get(i).getBanglaword());
        dictionaryRecycleViewHolder.txt_ChineseWord.setText("Chinese-> "+item_DicWordDetail.get(i).getChineseword());
        dictionaryRecycleViewHolder.txt_BanglaWordPron.setText("উচ্চারণ: "+item_DicWordDetail.get(i).getPronctnbangla());
        dictionaryRecycleViewHolder.txt_ChineseWordPron.setText("发音/Pinyin: "+item_DicWordDetail.get(i).getPronctnchinese());
     //   dictionaryRecycleViewHolder.txt_EnglishWord.setText(Integer.toString(item_adminDetail.get(i).getId()));
    }

    @Override
    public int getItemCount() {

       return item_DicWordDetail.size();

    }

 //region For Search
    @Override
    public Filter getFilter() {
        return filterlistforsearch;
    }
    private Filter filterlistforsearch=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DictionaryDetailcls> filteredList= new ArrayList<>();
            if(constraint==null||constraint.length()==0){
                filteredList.addAll(item_DicWordDetailfullList);
            }
            else {
                String filterPattern=constraint.toString().toLowerCase().trim();
                for(DictionaryDetailcls item:item_DicWordDetailfullList){
                    if(item.getEnglishword().toLowerCase().contains(filterPattern)||item.getChineseword().toLowerCase().contains(filterPattern)||
                            item.getBanglaword().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);

                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            item_DicWordDetail.clear();;
            item_DicWordDetail.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
    //endregion
// region for click in the ListviewItems
    public interface ClickListenerWordRV{
        void OnItemClick(int position,View view);
//        void OnItemLongClick(int position,View view);
//
//        void OnItemTouch(int id, View v);
    }
    public void setOnItemClickListener(ClickListenerWordRV clickListenerr){
       DictionaryRclcylerViewHolderAdapter.clickListenerWordRV=clickListenerr;
    }
    //endregion
}
class DictionaryRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//DictionaryRclcylerViewHolderAdapter.ClickListenerWordRV clickListenerWordRV;

    TextView txt_EnglishWord,txt_ChineseWord,txt_Banglaword,txt_BanglaWordPron,txt_ChineseWordPron,txtWordId;
    public DictionaryRecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        txtWordId=(TextView)itemView.findViewById(R.id.txtWordidforlv);
        txt_EnglishWord=(TextView)itemView.findViewById(R.id.txtEnglishWordid);
        txt_ChineseWord=(TextView) itemView.findViewById(R.id.txtChineseWordid);
        txt_Banglaword=(TextView)itemView.findViewById(R.id.txtBanglaWordid);
        txt_BanglaWordPron=(TextView)itemView.findViewById(R.id.txtBanglaWordPronid);
        txt_ChineseWordPron=(TextView)itemView.findViewById(R.id.txtChineseWordPronid);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        clickListenerWordRV.OnItemClick(item_DicWordDetail.get(getAdapterPosition()).getWordID(),v);
    }
}