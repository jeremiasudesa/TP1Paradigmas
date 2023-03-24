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
const tint MAXN = 1e9;

tint sqrt2(tint num)
{
    tint a = 0, b = MAXN + 1;
    while (b - a > 1)
    {
        tint mid = (a + b) / 2;
        if (mid * mid > num)
            b = mid;
        else
            a = mid;
    }
    return b - 1;
}

int main()
{
    fastIO();
    tint t;
    cin >> t;
    while (t--)
    {
        tint n;
        cin >> n;
        if (n == 1)
        {
            cout << "0\n";
            continue;
        }
        if (n <= 4)
        {
            cout << "1\n";
            continue;
        }
        tint ans = sqrt2(n);
        if (ans * ans >= n)
            cout << ans - 1 << "\n";
        else
            cout << ans << "\n";
    }
}