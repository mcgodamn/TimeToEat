package com.example.timetoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;
import java.util.*;

import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static Shop[] shop = new Shop[100];
    public static Shop[] count = new Shop[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button subbutton = (Button)findViewById(R.id.sub);
        subbutton.setOnClickListener(decision);
        Button button01 = (Button)findViewById(R.id.addbutton);
        button01.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(isExtStorageReadable()){
                    jumptoadd();
                }
                else Toast.makeText(MainActivity.this, "無法讀取外部裝置!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private static String nlnspe(int pen) {
        int j=0,temp =0,k=0,res;
        Random ran = new Random();
        for(int i=0;i<pen;i++){
            if((shop[i].lazy == 0)&&(shop[i].spe == 0)){
                count[j] = new Shop();
                count[j].name = shop[i].name;
                count[j].love = shop[i].love;
                j++;
            }
        }
        for(int i=0;i<j;i++){
            temp+=count[i].love;
        }
        res = ran.nextInt(temp+1)+1;
        while(true){
            if (res<=count[k].love)
            {
                return count[k].name;
            }
            else {
                res-=count[k].love;
                k++;
            };
        }
    }
    private static String lanspe(int pen) {
        int j=0,temp =0,k=0,res;
        Random ran = new Random();
        for(int i=0;i<pen;i++){
            if((shop[i].lazy == 1)&&(shop[i].spe == 0)){
                count[j] = new Shop();
                count[j].name = shop[i].name;
                count[j].love = shop[i].love;
                j++;
            }
        }
        for(int i=0;i<j;i++){
            temp+=count[i].love;
        }
        res = ran.nextInt(temp+1)+1;
        while(true){
            if (res<=count[k].love)
            {
                return count[k].name;
            }
            else {
                res-=count[k].love;
                k++;
            };
        }
    }
    private static String spenl(int pen) {
        int j=0,temp =0,k=0,res;
        Random ran = new Random();
        for(int i=0;i<pen;i++){
            if(shop[i].lazy == 0){
                count[j] = new Shop();
                count[j].name = shop[i].name;
                count[j].love = shop[i].love;
                j++;
            }
        }
        for(int i=0;i<j;i++){
            temp+=count[i].love;
        }
        res = ran.nextInt(temp+1)+1;
        while(true){
            if (res<=count[k].love)
            {
                return count[k].name;
            }
            else {
                res-=count[k].love;
                k++;
            };
        }
    }
    private static String spela(int pen) {
        int j=0,temp =0,k=0,res;
        Random ran = new Random();
        for(int i=0;i<pen;i++){
            if(shop[i].lazy == 1){
                count[j] = new Shop();
                count[j].name = shop[i].name;
                count[j].love = shop[i].love;
                j++;
            } 
        }
        for(int i=0;i<j;i++){
            temp+=count[i].love;
        }
        res = ran.nextInt(temp+1)+1;
        while(true){
            if (res<=count[k].love)
            {
                return count[k].name;
            }
            else {
                res-=count[k].love;
                k++;
            };
        }
    }
    public boolean isExtStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    private static void zero(String num) throws zeroexception{
		if(num.compareTo("0") == 0){
			throw new zeroexception();
		} 
		
	}
	private static void big(String num) throws bigexception{
		if(num.length() > 8){
			throw new bigexception();
		}
		else if(num.length() == 10){
			if(num.compareTo("2147483647") > 0){
				throw new bigexception();
			}
		}
	}
	private static void ne(String num) throws neexception{
		if(num.compareTo("0") < 0){
			throw new neexception();
		} 
	}
	private static void id(String num) throws idexception{
		if(num.compareTo("87") == 0){
			throw new idexception();
		} 
	}
	private static void empty(String num) throws emptyexception{
		if(num.compareTo("") == 0){
			throw new emptyexception();
		}
	}
	private static void zeroi(int num) throws zeroiexception{
		if(num == 0){
			throw new zeroiexception();
		}
	}
	public void renew(){
		EditText shopname = (EditText) findViewById(R.id.shopname);
        EditText shoplove = (EditText) findViewById(R.id.shoplove);
        CheckBox specb = (CheckBox) findViewById(R.id.addspecb);
        CheckBox lazycb = (CheckBox) findViewById(R.id.addlazycb);
        shopname.setText("");
        shoplove.setText("");
        specb.setChecked(false);
        lazycb.setChecked(false);
	}
    public void jumptoadd(){
        setContentView(R.layout.add);
        Button button02= (Button)findViewById(R.id.back);
        Button addbutton = (Button)findViewById(R.id.addsub);
        addbutton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v2) {
                File data = null;
                File mSDFile = null;
                File mfile = null;
                EditText shopname = (EditText) findViewById(R.id.shopname);
                EditText shoplove = (EditText) findViewById(R.id.shoplove);
                CheckBox specb = (CheckBox) findViewById(R.id.addspecb);
                CheckBox lazycb = (CheckBox) findViewById(R.id.addlazycb);
                String name = shopname.getText().toString();
                mSDFile = Environment.getExternalStorageDirectory();
                mfile = new File(mSDFile.getParent() + "/" + mSDFile.getName() + "/TimeToEat");
                if (!mfile.exists()) {
                    mfile.mkdirs();
                }
                data = new File(mSDFile.getParent() + "/" + mSDFile.getName() + "/TimeToEat/data.txt");
                try{
                	empty(name);
                	empty(shoplove.getText().toString());
                	try{
                		zero(shoplove.getText().toString());
                		try{
                			big(shoplove.getText().toString());
                			try{
                				ne(shoplove.getText().toString());
                			}
                			catch(neexception e){
                				
                			}
                		}
                		catch(bigexception e){
                			Toast.makeText(MainActivity.this, "喜愛度太大了喔!", Toast.LENGTH_SHORT).show();
                        	renew();
                        	return;
                		}
                	}
                	catch(zeroexception e){
                		Toast.makeText(MainActivity.this, "喜愛度不能是0!", Toast.LENGTH_SHORT).show();
                    	renew();
                    	return;
                	}
                }
                catch(emptyexception e){
                	Toast.makeText(MainActivity.this, "店家名跟喜愛度不能空白!", Toast.LENGTH_SHORT).show();
                	renew();
                	return;
                }
                        try {
                        	FileWriter fw = new FileWriter(data, true);
                            int love = Integer.parseInt(shoplove.getText().toString());
                            if (specb.isChecked() && lazycb.isChecked()) {
                                fw.write('\n' + name + " " + love + " 1 1");
                                Toast.makeText(MainActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
                                renew();
                                fw.close();
                                return;
                            } else if (specb.isChecked()) {
                                fw.write('\n' + name + " " + love + " 1 0");
                                Toast.makeText(MainActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
                                renew();
                                fw.close();
                                return;
                            } else if (lazycb.isChecked()) {
                                fw.write('\n' + name + " " + love + " 0 1");
                                Toast.makeText(MainActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
                                renew();
                                fw.close();
                                return;
                            } else {
                                fw.write('\n' + name + " " + love + " 0 0");
                                Toast.makeText(MainActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
                                renew();
                                fw.close();
                                return;
                            }
                        } catch (IOException e) {
                        	renew();
                            Toast.makeText(MainActivity.this, "添加失敗!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
        });
        button02.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                jumptomain();
            }
        });
    }
    public void jumptomain() {
        setContentView(R.layout.activity_main);
        Button button01 = (Button) findViewById(R.id.addbutton);
        button01.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                jumptoadd();
            }
        });
        Button subbutton = (Button)findViewById(R.id.sub);
        subbutton.setOnClickListener(decision);
    }
    public OnClickListener decision = new OnClickListener(){
        public void onClick(View v3){
        	String[] inp;
            TextView result = (TextView)findViewById(R.id.result);
            CheckBox specb = (CheckBox)findViewById(R.id.specb);
            CheckBox lazycb = (CheckBox)findViewById(R.id.lazycb);
            int i;
            Scanner inputstream = null;
            File data = null;
            File mSDFile = null;
            File mfile = null;
            if (isExtStorageReadable()){
                try
                {
                    i=0;
                    mSDFile = Environment.getExternalStorageDirectory();
                    mfile = new File(mSDFile.getParent() + "/" + mSDFile.getName() + "/TimeToEat");
                    if(!mfile.exists())
                    {
                        mfile.mkdirs();
                    }
                    data = new File(mSDFile.getParent() + "/" + mSDFile.getName() + "/TimeToEat/data.txt");
                    inputstream = new Scanner(data);
                    if(inputstream.hasNextLine()){
                        while(inputstream.hasNextLine()){
                            shop[i] = new Shop();
                            inp = inputstream.nextLine().split(" ");
                            while(inp.length != 4){
                            	if(!inputstream.hasNextLine()){
                            		break;
                            	}
                            	else inp = inputstream.nextLine().split(" ");
                            }
                            shop[i].name = inp[0];
                            if(shop[i].name.equals("\n") ||shop[i].name.equals(" ")){
                                break;
                            }
                            shop[i].love = Integer.parseInt(inp[1]);
                            shop[i].spe = Integer.parseInt(inp[2]);
                            shop[i].lazy = Integer.parseInt(inp[3]);
                            i++;//i最後會是總筆數
                        }
                    }
                    else {
                        result.setText("找不到資料喔!");
                        inputstream.close();
                        return;
                    }
                    try{
                    	zeroi(i);
                    }
                    catch(zeroiexception e){
                    	result.setText("沒有相關店家喔!");
                        inputstream.close();
                        return;
                    }
                    if(specb.isChecked()&&lazycb.isChecked()){
                        result.setText("就決定是"+ spela(i) +"這間店了!");
                        inputstream.close();
                        return;
                    }
                    else if(specb.isChecked()||lazycb.isChecked()){
                        if(specb.isChecked()){
                            result.setText("就決定是"+ spenl(i) +"這間店了!");
                            inputstream.close();
                            return;
                        }
                        else result.setText("就決定是"+ lanspe(i) +"這間店了!");
                        inputstream.close();
                        return;
                    }
                    else result.setText("就決定是"+ nlnspe(i) +"這間店了!");
                    inputstream.close();
                    return;
                }
                catch (FileNotFoundException e2)
                {
                    result.setText("找不到資料檔案喔!");
                    return;
                }
            }
            else{
                result.setText("無法讀取外部裝置!");
                return;
            }
        }
    };
}
class zeroexception extends Exception{
	public void zeroexception(){

	}
}
class bigexception extends Exception{
	public void bigexception(){
		
	}
}
class neexception extends Exception{
	public void neexception(){
		
	}
}
class idexception extends Exception{
	public void idexception(){
		
	}
}
class emptyexception extends Exception{
	public void emptyexception(){
		
	}
}
class zeroiexception extends Exception{
	public void zeroiexception(){
		
	}
}
