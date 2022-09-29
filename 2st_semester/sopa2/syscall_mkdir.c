#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(){
	int status = mkdir("/home/pedro/Development/Git Space/my_graduation_codes/2st_semester/sopa2/created_folder_syscall", 0777);

	if(status != 0){
		printf("Error");
	}

	return 0;
}
