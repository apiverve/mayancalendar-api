using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.MayanCalendar
{
    /// <summary>
    /// Query options for the Mayan Calendar API
    /// </summary>
    public class MayanCalendarQueryOptions
    {
        /// <summary>
        /// The Gregorian date in YYYY-MM-DD format
        /// Example: 2024-12-21
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }
    }
}
