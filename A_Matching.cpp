#include <bits/stdc++.h>
#define forn(i, n) for (int i = 0; i < int(n); i++)
#define forsn(i, s, n) for (int i = s; i < int(n); i++)
#define dforn(i, n) for (int i = int(n) - 1; i >= 0; i--)
#define dforsn(i, s, n) for (int i = int(n) - 1; i >= s; i--)
#define sz(x) int(x.size())
#define all(x) x.begin(), x.end()
#define rall(x) x.rbegin(), x.rend()
#define DBG(x) cerr << #x << " = " << x << endl

using namespace std;
using tint = long long;
using vi = vector<tint>;

inline void fastIO()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}

inline string YN(bool x, string y = "YES", string n = "NO")
{
    return (x ? y : n);
}

template <typename T>
inline void chmax(T &lhs, T rhs)
{
    lhs = max(lhs, rhs);
}

template <typename T>
inline void chmin(T &lhs, T rhs)
{
    lhs = min(lhs, rhs);
}

template <typename T>
ostream &operator<<(ostream &os, vector<T> &v)
{
    os << "[";
    forn(i, sz(v))
    {
        if (i > 0)
            os << ", ";
        os << v[i];
    }
    os << "]";
    return os;
}

template <typename T, typename U>
ostream &operator<<(ostream &os, pair<T, U> &p)
{
    os << "(" << p.first << ", " << p.second << ")";
    return os;
}

int main()
{
    fastIO();
    tint t;
    cin >> t;
    while (t--)
    {
        string s;
        cin >> s;
        tint c = 1;
        tint n = sz(s);
        forn(i, n)
        {
            if (s[i] != '?')
                continue;
            if (i == 0)
                c *= 9;
            else
                c *= 10;
        }
        if (s[0] == '0')
            c = 0;
        cout << c << "\n";
    }
}