#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(){
	int status = rmdir("/home/pedro/Development/Git Space/my_graduation_codes/2st_semester/sopa2/created_folder_syscall");

	if(status != 0){
		printf("Error");
	}

	return 0;
}
