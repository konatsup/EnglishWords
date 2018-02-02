package konatsup.englishwords;


import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word>{
    List<Word> mWords;
    public WordAdapter(Context context, int layoutResourceId, List<Word> objects){
        super(context, layoutResourceId, objects);

        mWords = objects;
    }

    public static class ViewHolder{
        TextView enTextView;
        TextView jpTextView;

        public ViewHolder(View view){
            enTextView = (TextView) view.findViewById(R.id.enTextView);
            jpTextView = (TextView) view.findViewById(R.id.jpTextView);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        // Viewを再利用している場合は新たにViewを作らない
        if (convertView == null) {
            convertView =  LayoutInflater.from(getContext()).inflate(R.layout.word, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Word item = getItem(position);

        if(item != null){

            viewHolder.enTextView.setText(item.en_word);
            viewHolder.jpTextView.setText(item.jp_word);
            viewHolder.enTextView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(viewHolder.enTextView.getText().toString()==""){
                        viewHolder.enTextView.setText(item.en_word);
                    }else {
                        viewHolder.enTextView.setText("");
                    }
                }
            });
            viewHolder.jpTextView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(viewHolder.jpTextView.getText().toString()==""){
                        viewHolder.jpTextView.setText(item.jp_word);
                    }else {
                        viewHolder.jpTextView.setText("");
                    }
                }
            });
        }
//        // 特定の行のデータを取得
//        String str = getItem(position);
//
//        if (!TextUtils.isEmpty(str)) {
//            // テキストビューにラベルをセット
//            holder.labelText.setText(str);
//        }
//
//        // 行毎に背景色を変える
//        if(position%2==0){
//            holder.labelText.setBackgroundColor(Color.parseColor("#aa0000"));
//        }else{
//            holder.labelText.setBackgroundColor(Color.parseColor("#880000"));
//        }
//
//        // XMLで定義したアニメーションを読み込む
//        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.item_motion);
//        // リストアイテムのアニメーションを開始
//        view.startAnimation(anim);
        return convertView;
    }
//    @Override
//    public int getCount(){
//        return mWords.size();
//    }


}