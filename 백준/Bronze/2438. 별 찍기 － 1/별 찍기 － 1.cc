#include <iostream>

using namespace std;

int main()
{
	int n = 0;

	cin >> n;


	if (n >= 1 && n <= 100) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				cout << "*";
			}
			cout << endl;
		}
	}
	else
		return 0;
}