#include <iostream>
//fstream is a stream class to both read and write from/to files.
#include <fstream>
#include <iomanip>
#include <string.h>

using namespace std;

main(){
	string line1[50];
	string line2[50];
	string line3[50];
	string line4[50];
	string first;
	string second;
	string third;
	string fourth;
	
	ifstream file1;
	ifstream file2;
	ifstream file3;
	ifstream file4;
	
	//first program to read
	file1.open("prog1.cpp", ios::in);
	//ios::in is opening a file for input operations
	int a=0;
	if(file1.is_open()){
		cout<<"prog1.cpp opened."<<'\n';
		while(getline(file1, first)){
			cout<<first<<'\n';
			line1[a] = first;
			a++;
		}
		file1.close();
	}
	else cout<<"Unable to open file";
	
	//second program to read
	file2.open("prog2.cpp", ios::in);
	//ios::in is opening a file for input operations
	int b=0;
	if(file2.is_open()){
		cout<<"\nprog2.cpp opened."<<'\n';
		while(getline(file2, second)){
			cout<<second<<'\n';
			line2[b] = second;
			b++;
		}
		file2.close();
	}
	else cout<<"Unable to open file";
	
	//comparing both programs
	int percent1=100, i=0;
	for(i=0; i<4; i++){
		if(line1[i]==line2[i]) continue;
		else{
			percent1--;
		}
	}
	cout<<"\nSimilarity Percentage: "<<percent1<<'\n';
	
	/*************************************************/
	
	//first java program to read
	file3.open("prog1.java", ios::in);
	//ios::in is opening a file for input operations
	int c=0;
	if(file3.is_open()){
		cout<<"\nprog1.java opened."<<'\n';
		while(getline(file3, third)){
			cout<<third<<'\n';
			line3[c] = third;
			c++;
		}
		file3.close();
	}
	else cout<<"Unable to open file";
	
	//second java program to read
	file4.open("prog2.java", ios::in);
	//ios::in is opening a file for input operations
	int d=0;
	if(file4.is_open()){
		cout<<"\nprog2.java opened."<<'\n';
		while(getline(file4, fourth)){
			cout<<fourth<<'\n';
			line4[d] = fourth;
			d++;
		}
		file4.close();
	}
	else cout<<"Unable to open file";
	
	//comparing both programs
	int percent2=100, j=0;
	for(j=0; j<5; j++){
		if(line3[j]==line4[j]) continue;
		else{
			percent2--;
		}
	}
	cout<<"\nSimilarity Percentage: "<<percent2<<'\n';
	
	
	return 0;
}

//reference: http://www.cplusplus.com/doc/tutorial/files/
